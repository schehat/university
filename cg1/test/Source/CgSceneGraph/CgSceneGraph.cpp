#include "CgSceneGraph.h"

CgSceneGraph::CgSceneGraph()
{

}

void CgSceneGraph::pushMatrix(glm::mat4 matrix) {m_modelview_matrix_stack.push(matrix);}
void CgSceneGraph::popMatrix() {m_modelview_matrix_stack.pop();}
void CgSceneGraph::applyTransform(glm::mat4 arg) {m_modelview_matrix_stack.top() *= arg;}

void CgSceneGraph::render(CgBaseRenderer *renderer) {
    m_root_node->iterateAllChildren_DFS();
}

CgSceneGraphEntity* CgSceneGraph::getRootNode() {return m_root_node;}
std::stack<glm::mat4> CgSceneGraph::getModelviewMatrixStack() {return m_modelview_matrix_stack;}

void CgSceneGraph::setModelviewMatrixStack(std::stack<glm::mat4> modelview_matrix_stack) {
    while (!m_modelview_matrix_stack.empty()) m_modelview_matrix_stack.pop();
    std::stack<glm::mat4> temp_stack;
    int stack_size = modelview_matrix_stack.size();
    for (int i = 0; i < stack_size; ++i) {
        temp_stack.push(modelview_matrix_stack.top());
        modelview_matrix_stack.pop();
    }
    for (int i = 0; i < stack_size; ++i) {
        m_modelview_matrix_stack.push(temp_stack.top());
        temp_stack.pop();
    }
}
void CgSceneGraph::addModelviewMatrixStack(glm::mat4 modelview_matrix) {
    m_modelview_matrix_stack.push(modelview_matrix);
}
