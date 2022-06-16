# Computergrafik 1

Created a chess scene with QT and OpenGl.

Runs on Ubuntu 20.04. The GPU has to support OpenGl 3.3.

Controls: 
    - q: select objects 
    - w: unselect objects 
    - e: select group

Objects can be transformed when selected
Controls:   - First choose transformation mode, only one can be selected: 
                - t: translate 
                - s: scale 
                - r: rotate 
            - Choose which axis, will be toggled off on multiple presses
                - x 
                - y 
                - z 
            - Choose effect 
                - +     
                - - (minus)

A right click in the scene will created a picking ray. All Intersectopns with the objects will be marked with a red cube. In Addition all AABB-Boxes of the objects will be marked with a green cube. - a: show AABB-Box of selected object

The blue object in the center is the object in object coordinates placed in the scene and the blue ray projected from the scene to the object coordinates of the selected object.