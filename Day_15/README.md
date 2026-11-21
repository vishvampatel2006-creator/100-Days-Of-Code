# Day 15: Java Code Review & Bug Fixes (TaskManager)

Reviewed and refactored a buggy `TaskManager` class in Java.

## Issues Identified & Fixed
1. **String Comparison:** Replaced `==` with `.equals()` to compare values instead of memory references.
2. **ConcurrentModificationException:** Replaced `remove()` inside an enhanced `for` loop with `removeIf()`.
3. **Off-by-One Error:** Fixed `i <= tasks.size()` to `i < tasks.size()` in `printTasks()`.
4. **Empty List Handling:** Added `isEmpty()` checks in `getFirstTask()` and `printTasks()` to prevent `IndexOutOfBoundsException`.
5. **Encapsulation:** Changed `tasks` list from `public` to `private` and added `null`/blank validation in `addTask()`.