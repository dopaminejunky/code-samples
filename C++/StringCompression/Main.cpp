/*
** Roger Robertson
** Compressed String
** File description:
** Main
*/



#include "CompressedString.h"
#include <vector>
#include <iostream>

int main(int argc, char const *argv[])
{
    string testStr = "aaabbcdd";
    CompressedString test1(testStr);
    cout << endl;
    string string2 = "abc";
    CompressedString test2(string2);
    cout << endl;
    string string3 = "dddddddddffbbbwweweefffvvvvvvvggggggg";
    CompressedString test3(string3);

    return 0;
}
