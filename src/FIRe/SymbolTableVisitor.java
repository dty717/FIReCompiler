package FIRe;

@SuppressWarnings("ALL")
public class SymbolTableVisitor extends ASTVisitor {

    public SymbolTable ST = new SymbolTable();

    @Override
    public void visit(AbstractNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(AdditionNode node) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type || node.LeftChild.type == "bool")
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ActualParameterNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(AndNode node) throws Exception{
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "bool" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }


    @Override
    public void visit(ArrayAccessNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(AssignNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(BlockNode node) {
        ST.OpenScope();
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
        ST.CloseScope();
    }

    @Override
    public void visit(BodyColorNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(BooleanDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(BoolNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(Color node) {

    }

    @Override
    public void visit(ColorValNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(ControlStructureNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(DeclarationNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(DivisionNode node) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(EventDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(EqualsNode node) throws Exception{
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ExpressionNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(FormalParameterNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(ForNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(FuncCallNode node) {
        for (AbstractNode Node: node.childList)
            if (Node != null){
            VisitNode(Node);
        }
    }

    @Override
    public void visit(FunctionDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(GEQNode node) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type == "text" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(GreaterThanNode node) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(GunColorNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(IdNode node){
        try {
             ST.Search(node.name);
        }
        catch(Exception ex){}
    }

    @Override
    public void visit(IfControlStructureNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(InfixExpressionNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(LEQNode node) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(LessThanNode node) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type == "text" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ModuloNode node) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(MultiplicationNode node) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(NegateNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(NotEqualsNode node) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(NotNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(NumberDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(NumberNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(OrNode node) throws Exception{
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "bool" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(PowerNode node) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(ProgNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RadarColorNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(ReturnNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RobotDclBodyNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RoutineNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(StatementNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(StrategyDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(SubtractionNode node) throws Exception {
        VisitNode(node.LeftChild);
        VisitNode(node.RightChild);

        if(node.LeftChild.type != "number" || node.LeftChild.type != node.RightChild.type)
            throw new TypeException();

        node.type = node.LeftChild.type;
    }

    @Override
    public void visit(TextDeclarationNode node) throws Exception {
        ST.Insert(node);
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(TextNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(ValNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    @Override
    public void visit(WhenNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

    public void visit(ArrayDeclarationNode node){
        for (AbstractNode Node: node.childList){
            if (Node != null)
                VisitNode(Node);
        }
    }

    @Override
    public void visit(WhileNode node) {
        for (AbstractNode Node: node.childList) {
            if (Node != null)
            VisitNode(Node);
        }
    }

}
