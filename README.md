# 2023 FRC Field Signed Distance Function

Based primarily on [6328's FieldConstants.java](https://github.com/Mechanical-Advantage/RobotCode2023/blob/main/src/main/java/org/littletonrobotics/frc2023/FieldConstants.java).

A [signed distance function](https://en.wikipedia.org/wiki/Signed_distance_function) is a function mapping points to the nearest distance to any obstacle. The sign determines if the point is within or outside the bounds. For our implementation, a positive distance is a valid robot position.

We've added a function to get the minimum distance from a point to any of the field boundaries including
- The Grids
- The Charging Station
- The Guardrail between the Loading Station and Community
- The Field Perimeter

![SDF Example](assets/simple.png)

Additionally, you may model your robot as a circle and find the SDF of the configuration space

![SDF radii Example](assets/radii.png)

*Future Work:*
- Probabilistic Road Maps
  + Use [this metric](http://www.cemyuksel.com/research/catmullrom_param/catmullrom_cad.pdf) for local connectivity
  + Deterministic sampling method
- 3D SDFs for non-circular models of a robot. The third dimension would parameterize robot heading.