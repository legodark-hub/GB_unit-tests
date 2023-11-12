from list_processor import ListProcessor

# print("введите первый список чисел через пробел")
list1 = input("введите первый список чисел через пробел\n").split()
list2 = input("введите второй список чисел через пробел\n").split()

list1 = [float(i) for i in list1]
list2 = [float(i) for i in list2]

print(ListProcessor(list1, list2).compare_lists())
