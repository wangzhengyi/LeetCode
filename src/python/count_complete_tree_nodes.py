#!/usr/bin/python

class TreeNode:
    def __init__(self, x):
        self.var = x
        self.left = None
        self.right = None

class Solution:
    def countNodes(self, root):
        height = self.calculateHeight(root)
        if height == 0: return 0
        if height == 1: return 1
        bt = 0
        ed = 1 << (height - 1) - 1
        while bt <= ed:
            mid = bt + (ed - bt) / 2
            if self.isNodeExist:
                bt = mid + 1
            else:
                ed = mid - 1
        
        return 2 ** (height - 1) - 1 + bt


    def calculateHeight(self, root):
        height = 0
        while root is not None:
            height += 1
            root = root.left
        return height

    def isNodeExist(self, mid, height, root):
        high = 0
        stand = 1 << (height - 2)

        while high < height - 1 and root != None:
            if mid & stand == 1:
                root = root.right
            else:
                root = root.left
            mid <<= 1
            high += 1

        if root != None:
            return True
        else:
            return False

