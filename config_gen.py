import xml.etree.ElementTree as et
import re

"""Generates the configuration xml files for the STARCCM+ macro."""

# Set up xml tree structure
ind = et.Element("index")
partsList = et.SubElement(ind, "partsList")

def addPart(part):
    """ Add a part to the xml file under the partsList subelement.
    part must be a dictionary, containing the element with key
    "NAME" which defines the name of the part."""

    item = et.SubElement(partsList, part["NAME"])
    for name in part:
        data = part[name]
        if name != "NAME":
            # Handle tuples by assigning x, y, z coords
            if isinstance(data, tuple):
                num = re.findall("[0-9]+$", name)
                xyz = ["x","y","z"]
                vector = et.SubElement(item, name)
                for i in range(len(data)):
                    coord = et.SubElement(vector, xyz[i]+num[-1])
                    coord.text = str(data[i])
            else:
                subItem = et.SubElement(item, name)
                subItem.text = str(data)
                #item.set(name, str(part[name]))


def addSettings(part):
    """ Add settings to the xml file.
    part must be a dictionary, containing the element with key
    "NAME" which defines the name of the part."""

    item = et.SubElement(ind, part["NAME"])
    for name in part:
        data = part[name]
        if name != "NAME":
            subItem = et.SubElement(item, name)
            subItem.text = str(data)
# Define the properties for a part (e.g. front-left wheel)
fl = {
    "NAME": "flwheel",
    "ang_vel": 16.66/0.4064,
    "vec0": (0.0, 0.1995, 1.55)
    "vec1": (1.0, 0., 0.),
}

fr = {
    "NAME": "rlwheel",
    "ang_vel": 16.66/0.4064,
    "vec0": (0.0, 0.1995, 1.55), #origin vector
    "vec1": (1.0, 0., 0.), # axis vector
}

rl = {
    "NAME": "rlwheel",
    "ang_vel": 16.66/.4064,
    "vec0": (0.0, 0.1995, 0),
    "vec1": (1.0, 0., 0.),
}

rr = {
    "NAME": "rlwheel",
    "ang_vel": 16.66/0.4064,
    "vec0": (0.0, 0.1995, 0),
    "vec1": (1.0, 0., 0.),
}

floor = {
    "NAME": "floor",
    "vec0": (0, 0, -16.66)
}

inlet = {
    "NAME": "in",
    "vel": 16.66
}



addPart(fl)
addPart(rl)
addPart(rr)
addPart(fr)
addPart(floor)
addPart(inlet)

# Mesh settings
mesh = {
    "NAME": "mesh",
    "Base_Size": 100.,  # mm
    "No_Prism": 2,
    "Prism_Total_Thickness": 66.66,  # %
    "Max_Cell_Size": 37500,  # %
    "No_BOI": 1,
    "BOI_Size_0": 100  # e.g. if No_BOI were 2, add BOI_Size_1
}

solver = {
    "NAME": "solver",
    "Std_Dev": 0.01,
    "Max_Steps": 3000
}

addSettings(mesh)
addSettings(solver)

#Write the xml
tree = et.ElementTree(ind)
tree.write("sim_config.xml")

