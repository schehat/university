#include "CgPolyline.h"
#include "CgBase/CgEnums.h"
#include "CgUtils/ObjLoader.h"

CgPolyline::CgPolyline():
m_type(Cg::Polyline),
m_id(42)
{

}

CgPolyline::CgPolyline(int id, glm::vec3 p1, glm::vec3 p2):
m_type(Cg::Polyline),
m_id(id)
{
    m_vertices.push_back(p1);
    m_vertices.push_back(p2);
}

CgPolyline::~CgPolyline(){
    m_vertices.clear();
    //m_face_colors.clear();
}

const std::vector<glm::vec3>& CgPolyline::getVertices() const
{
    //return m_vertices;
}

glm::vec3 CgPolyline::getColor() const {
    return m_face_colors;
}
unsigned int CgPolyline::getLineWidth() const {
    return m_line_width;
}
