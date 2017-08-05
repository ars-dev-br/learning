object InnerClasses extends App {
  class Graph {
    class Node {
      var connectedNodes: List[Node] = Nil
      def connectTo(node: Node) {
        if (connectedNodes.find(node.equals).isEmpty) {
          connectedNodes = node :: connectedNodes
        }
      }
    }

    var nodes: List[Node] = Nil
    def newNode: Node = {
      val res = new Node
      nodes = res :: nodes
      res
    }
  }

  val graph1: Graph = new Graph
  val node1: graph1.Node = graph1.newNode
  val node2: graph1.Node = graph1.newNode
  val node3: graph1.Node = graph1.newNode
  node1.connectTo(node2)
  node3.connectTo(node1)

  val graph2: Graph = new Graph
  val node4: graph2.Node = graph2.newNode
  // node1.connectTo(node4) // illegal

  class Graph2 {
    class Node {
      var connectedNodes: List[Graph2#Node] = Nil
      def connectTo(node: Graph2#Node) {
        if (connectedNodes.find(node.equals).isEmpty) {
          connectedNodes = node :: connectedNodes
        }
      }
    }

    var nodes: List[Node] = Nil
    def newNode: Node = {
      val res = new Node
      nodes = res :: nodes
      res
    }
  }

  val graph3: Graph2 = new Graph2
  val node5: graph3.Node = graph3.newNode
  val node6: graph3.Node = graph3.newNode
  val node7: graph3.Node = graph3.newNode
  node5.connectTo(node6)
  node7.connectTo(node5)

  val graph4: Graph2 = new Graph2
  val node8: graph4.Node = graph4.newNode
  node5.connectTo(node8) // legal
}
