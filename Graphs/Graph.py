class Graph:
	
	adj_list = None
	weights = None
	
	def __init__(self):
		self.adj_list =	{
			1: [2,3,6],
            2: [1,3,4],
            3: [1,2,4,6],
            4: [2,3,5,7],
            5: [4,6,7],
            6: [1,3,5,7],
            7: [4,5,6]
        }

		self.weights = { 
			(1,2):7,
            (1,3):9,
            (1,6):14,
            (2,3):10,
            (2,4):15,
            (3,4):11,
            (3,6):2,
            (4,5):6,
            (5,6):9,
            (4,7):2,
            (5,7):1,
            (6,7):12
        }

	def breadthFirstSearch(self, key):
		from MyQueue import Queue

		nodes_to_visit = Queue()
		visited_nodes = []

		for i in range(0, len(self.adj_list)):

			for j in self.adj_list[i]:
				if j not in visited_nodes:
					nodes_to_visit.put(j)
				else:
					pass

			while nodes_to_visit.size > 0:

				current_node = nodes_to_visit.get()

				if current_node == key:
					print "| %s |" % current_node
				else:
					print current_node 

				visited_nodes.append(current_node)

	def depthFirstSearch(self, key):
		from Stack import Stack

		nodes_to_visit = Stack()
		visited_nodes = []

		for i in range(0, len(self.adj_list)):

			for j in self.adj_list[i]:
				if j not in visited_nodes:
					nodes_to_visit.push(j)
				else:
					pass

			while nodes_to_visit.size > 0:
				current_node = nodes_to_visit.pop()

				if current_node == key:
					print "| %s |" % current_node
				else:
					print current_node

				visited_nodes.append(current_node)


			
if __name__ == "__main__":
	graph = Graph()

	print "BFS -------------" * 3
	graph.breadthFirstSearch(3)
	print "DFS -------------" * 3
	graph.depthFirstSearch(3)



