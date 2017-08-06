# FIFO implementation of a queue

class Queue(object):
	struct = None
	size = None
	first_item = None

	def __init__(self):
		self.struct = []
		self.size = 0
		self.first_item = None
		return

	def put(self, item):
		if self.size == 0:
			self.first_item = item
		
		self.struct.append(item)
		self.size += 1
		return

	def put_list(self, li):
		if self.size == 0:
			self.first_item = li[0]

		for item in li:
			self.put(item)

		return

	def get(self):
		if self.isEmpty():
			raise IndexError("No items in Queue")
		else:
			returned_item = self.struct[0]
			self.struct = self.struct[1:]
			self.size -= 1

			return returned_item

	def peek(self):
		if self.isEmpty():
			return None
		else:
			return self.struct[0]

	def isEmpty(self):
		return self.size == 0

	def empty():
		self.struct = []
		self.size = 0
		self.first_item = None

if __name__ == "__main__":
	q = Queue()
	print "Is queue empty: ", q.isEmpty()
	for i in range(5):
		q.put(i)
	print "First item is: ", q.peek()
	print "Removed first item: ", q.get()
	print "Size of queue: ", q.size




