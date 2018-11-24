/*
 * Created on Wed Oct 31 2018
 *
 * Copyright (c) 2018 Roger Robertson Jr
 */
#ifndef SET_H_
#define SET_H_
#include <map>
using namespace std;

template<class T>
class Set {

    public:
    Set();
    ~Set();
    void add(T key);
    int getCount(T key);
    void printTopThree();
    void print();


    private: 
    map<T, int> Map;
};

#endif // !SET_H_
