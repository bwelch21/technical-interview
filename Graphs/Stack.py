# LIFO implementation of a Stack

class Stack(object):
	
	struct = None
	size = None
	last_item = None

	def __init__(self):
		self.struct = []
		self.size = 0

	def push(self, item):
		self.struct.append(item)
		self.size += 1

	def pop(self):
		self.size -= 1
		return self.struct.pop()


	def isEmpty(self):
		return self.size == 0

	def printStack(self):
		print self.struct

if __name__ == "__main__":
	s = Stack()
	for i in range(1, 6):
		s.push(i)

	s.printStack()

	print s.pop()
	print s.pop()

	s.printStack()



