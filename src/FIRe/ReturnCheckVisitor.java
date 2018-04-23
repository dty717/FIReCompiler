package FIRe;
import FIRe.Exceptions.ReturnException;
import FIRe.Exceptions.TypeException;
import javafx.beans.binding.When;


public class ReturnCheckVisitor extends ASTVisitor {

    public ReturnCheckVisitor(SymbolTable symbolTable){

        table = symbolTable;
    }

    private SymbolTable table;

    @Override
    public void visit(AbstractNode node, Object... arg) {

    }

    @Override
    public void visit(AdditionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {

    }

    @Override
    public void visit(AndNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ArrayAccessNode node, Object... arg) {

    }

    @Override
    public void visit(AssignNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BlockNode node, Object... arg) throws Exception {

        boolean hasreturn = false;
        AbstractNode parentNode = null;
        int returnFlag = 0;
        ReturnNode returnNode = null;

        for(AbstractNode child : node.childList){
            if(child instanceof ReturnNode){
                returnFlag++;
                returnNode = (ReturnNode) child;
            }

            else if(child instanceof ControlStructureNode)
                VisitNode(child);
        }

        if(returnFlag > 1)
            throw new ReturnException();
        else if(returnFlag == 1){
            if(node.Parent != null)
                parentNode = node.Parent;

            while(parentNode != null){
                if(parentNode instanceof FunctionDeclarationNode){
                    if(((FunctionDeclarationNode) parentNode).type != ((ExpressionNode) returnNode.childList.get(0)).type) {
                        throw new TypeException(((FunctionDeclarationNode) parentNode).type, ((ExpressionNode) returnNode.childList.get(0)).type,((ExpressionNode) returnNode.childList.get(0)).LineNumber );
                    }
                }
                parentNode = parentNode.Parent;
            }
        }

        //if(returnFlag == 1)
            //throw new ReturnException();
        // Der mangler noget heromkring der sikrer at en parents

      //  SymbolData data = table.Search(node.Parent.toString(),0);
        //if(hasreturn && data.type == "void"){
         //   throw new Exception("Ærgerligt");
       // } // tjek hvad returtypen er for funktionen i symboltable

    }

    @Override
    public void visit(BodyColorNode node, Object... arg) {

    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(BoolNode node, Object... arg) {

    }

    @Override
    public void visit(ColorValNode node, Object... arg) {

    }

    @Override
    public void visit(ControlStructureNode node, Object... arg) {

    }

    @Override
    public void visit(DeclarationNode node, Object... arg) {

    }

    @Override
    public void visit(DivisionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(EqualsNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {

    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {

    }

    @Override
    public void visit(ForNode node, Object... arg) throws ReturnException {
        /*AbstractNode nodeToCheck = null;
        int returnFlag = 0;
        AbstractNode parentNode = null;
        String returnType;
        ReturnNode returnNode = null;*/

        for(AbstractNode child : node.childList){
            if(child instanceof BlockNode){
                VisitNode(child);
                break;
            }
        }

       /* for(AbstractNode child : nodeToCheck.childList){
            if(child instanceof ReturnNode){
                returnFlag++;
                returnNode = (ReturnNode) child;
            }

            else if(child instanceof ControlStructureNode)
                VisitNode(child);
        }

        if(returnFlag > 1)
            throw new ReturnException();
        else if(returnFlag == 1){
            if(node.Parent != null)
                parentNode = node.Parent;

            while(parentNode != null){
                if(parentNode instanceof FunctionDeclarationNode){
                    if(((FunctionDeclarationNode) parentNode).type == ((ExpressionNode) returnNode.childList.get(0)).type) {
                        returnFlag = 0;
                        break;
                    }
                }
                parentNode = parentNode.Parent;
            }
        }

        if(returnFlag == 1)
            throw new ReturnException(); */
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) {

    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg) throws Exception {
        for (AbstractNode Node: node.childList) {
            if(Node instanceof BlockNode){
                VisitNode(Node);  //Visit each block node, since you only are allowed to have a return from within a block
            }
        }
    }

    @Override
    public void visit(GEQNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GreaterThanNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(GunColorNode node, Object... arg) {

    }

    @Override
    public void visit(IdNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            if (Node instanceof BlockNode) {
                VisitNode(Node);
            }
        }
         //   if(Node instanceof IfControlStructureNode){ // An ifcontrolstructurenode has block nodes as children. And a node for the boolean evaluation
         //       VisitNode(Node);
         //   }
    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(LEQNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(LessThanNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ModuloNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(MultiplicationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NegateNode node, Object... arg) {

    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NotNode node, Object... arg) {

    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(NumberNode node, Object... arg) {

    }

    @Override
    public void visit(OrNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(PowerNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(ProgNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            VisitNode(Node);
        }
    }

    @Override
    public void visit(RadarColorNode node, Object... arg) {

    }

    @Override
    public void visit(ReturnNode node, Object... arg) {
        for (AbstractNode Node: node.childList) {
            VisitNode(Node);
        }

    }

    @Override
    public void visit(RobotDclBodyNode node, Object... arg) {

    }

    @Override
    public void visit(RoutineNode node, Object... arg) {

    }

    @Override
    public void visit(StatementNode node, Object... arg) {

    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg) throws Exception {
        //int returnOkFlag = 0;

        for(AbstractNode child : node.childList){
            if(child instanceof ReturnNode){
                throw new ReturnException();
            }
            if(child instanceof ControlStructureNode || child instanceof WhenNode)
                VisitNode(child);

        }
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) throws Exception {

    }

    @Override
    public void visit(TextNode node, Object... arg) {

    }

    @Override
    public void visit(ValNode node, Object... arg) {

    }

    @Override
    public void visit(WhenNode node, Object... arg) {

    }

    @Override
    public void visit(WhileNode node, Object... arg) {

    }
}
