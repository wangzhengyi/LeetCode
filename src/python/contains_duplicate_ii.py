#!/usr/bin/python

class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {boolean}
    def containsNearbyDuplicate(self, nums, k):
        dict = {}
        for i in range(len(nums)):
            if dict.has_key(nums[i]):
                firIdx = dict.get(nums[i])
                if i - firIdx <= k:
                    return True
            dict[nums[i]] = i

        return False
