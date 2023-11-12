from list_processor import ListProcessor


def test_compare_lists_greater_first():
    list1 = [6, 7, 8, 9, 10]
    list2 = [1, 2, 3, 4, 5]
    processor = ListProcessor(list1, list2)
    result = processor.compare_lists()
    assert result == "Первый список имеет большее среднее значение"


def test_compare_lists_greater_second():
    list1 = [1, 2, 3, 4, 5]
    list2 = [6, 7, 8, 9, 10]
    processor = ListProcessor(list1, list2)
    result = processor.compare_lists()
    assert result == "Второй список имеет большее среднее значение"


def test_compare_lists_equal():
    list1 = [1, 2, 3]
    list2 = [3, 1, 2]
    processor = ListProcessor(list1, list2)
    result = processor.compare_lists()
    assert result == "Средние значения равны"


def test_compare_lists_empty_lists():
    list1 = []
    list2 = []
    processor = ListProcessor(list1, list2)
    result = processor.compare_lists()
    assert result == "Средние значения равны"
