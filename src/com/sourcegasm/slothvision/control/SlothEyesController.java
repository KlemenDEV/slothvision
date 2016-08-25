package com.sourcegasm.slothvision.control;

import com.sourcegasm.slothvision.gui.GUIAssembly;
import com.sourcegasm.slothvision.opensv.LocationData;
import com.sourcegasm.slothvision.opensv.SlothEyes;

import java.awt.image.BufferedImage;

public class SlothEyesController {
    private GUIAssembly guiAssembly;

    public SlothEyesController(GUIAssembly guiAssembly) {
        this.guiAssembly = guiAssembly;
    }

    public int calculateDistance() {
        BufferedImage image1 = guiAssembly.src1.getCurrentFrame();
        BufferedImage image2 = guiAssembly.src2.getCurrentFrame();

        if (image1 == null || image2 == null) {
            return 0;
        }

        LocationData data1 = SlothEyes.getMarkerData(image1);
        LocationData data2 = SlothEyes.getMarkerData(image2);

        if (data1.x == 0 || data2.x == 0) return 0;

        int distance = Math.abs(data1.x - data2.x);
        System.out.println(distance);
        return distance;
    }
}
