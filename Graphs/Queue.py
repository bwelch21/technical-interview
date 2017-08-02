# FIFO implementation of a queue

class Queue(object):
	
	def __init__(self):
		self.struct = []

	def put(self, item):
		self.struct.append(item)

	def get(self):
		if self.isEmpty():
			raise IndexError("No items in Queue")
		else:
			return self.struct[0]

	def isEmpty(self):
		return len(self.struct) == 0
