// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import frc.robot.util.Color;
import frc.robot.util.FieldConstants;

import java.awt.image.BufferedImage;

public final class Main {

  // Generates output.png
  private static void writeImage() throws IOException {
    int padding = 100; // padding/2 on each end of the field
    int width = (int) Math.ceil(Units.metersToInches(FieldConstants.fieldLength)) + padding;
    int height = (int) Math.ceil(Units.metersToInches(FieldConstants.fieldWidth)) + padding;
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for(int x = 0; x < width; x++) {
      for(int y = 0; y < height; y++) {
        double d = FieldConstants.fieldSdf(new Translation2d(Units.inchesToMeters(x - padding / 2), Units.inchesToMeters(y - padding / 2)));
        // converted from https://www.shadertoy.com/view/stcfzn
        Color col = new Color(1.0).sub(new Color(0.1, 0.4, 0.7).mul(Math.signum(d)));
        col.mulEq(1.0 - Math.exp(-2.0 * Math.abs(d)));
        col.mulEq(0.8 + 0.2 * Math.cos(30.0 * d));
        col = Color.mix(col, new Color(1.0), 1.0 - Color.smoothstep(0.0, 0.02, Math.abs(d)));
        col.clamp();

        image.setRGB(x, y, col.toInt());
      }
    }
    File outpuFile = new File("output.png");
    ImageIO.write(image, "png", outpuFile);
  }

  public static void main(String... args) throws IOException, IllegalArgumentException, IllegalAccessException {
    writeImage();
  }
}
