/*
 * Created on Wed Oct 31 2018
 *
 * Copyright (c) 2018 Roger Robertson Jr
 */
#include "Element.h"
#include "Element.cpp"
#include "Set.h"
#include "Set.cpp"
#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>

int main(int argc, char const *argv[])
{
    Element<int>Int1(5);
    Element<int>Int2(7);
     bool result = Int1 == Int2;
    cout << result << endl;
    Element<string>String1("hello");
    Element<string>String2("world");
    bool result2 = String1 == String2;
    cout << result2 << endl;
    Element<string>String3("hello");
    bool result3 = String3 == String1;
    cout << result3 << endl;
    Set<string>Set1;
    Set1.add("hello");
    Set1.add("hello");
    Set1.add("world");
    Set1.add("fox");
    Set1.add("fox");
    Set1.add("fox");
    Set1.add("fox");
    Set1.add("fox");
    Set1.add("fox");
    Set1.add("another");
    Set1.add("word");
    Set1.print();
    Set1.printTopThree();
    Set<Element<double>>Set2;
    Element<double>Element1(3.3);
    Element<double>Element2(3.3);
    Element<double>Element3(0.0);
    Set2.add(Element1);
    Set2.add(Element2);
    Set2.add(Element3);
    return 0;
};

