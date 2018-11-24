/*
 * Created on Wed Oct 31 2018
 *
 * Copyright (c) 2018 Roger Robertson Jr
 */
#include "Set.h"
#include "Element.h"
#include <string>
#include <map>
#include <vector>
#include <iostream>
#include <iterator>
#include <algorithm>

template<class T>
Set<T>::Set() {
    map<T, int> Map;
}

template<class T>
Set<T>::~Set() {
    cout << "Set destroyed." << endl;
}

// Big O Analysis: O(n^2)
template<class T>
void Set<T>::add(T key) {
    // if key exists
    if (Map.insert(std::make_pair(key, 1)).second == false) {
        // increment value
        Map[key]++;
    // otherwise add the key and set the counter to 1
    } else {
        Map.insert(std::make_pair(key, 1));
    }
}

template<class T>
int Set<T>::getCount(T key) {
    return Map[key];
}

template<class T>
void Set<T>::print() {
    typename map<T, int>::iterator it = Map.begin();
    while ( it != Map.end()) {
        cout << "KEY:" << it->first << " VALUE:" << it->second << endl;
        it++;
    }
}

//Big O Analysis: O(n^2)
template<class T>
void Set<T>::printTopThree() {
    // I wonder if I should have used vector<pair> all along?
    vector<pair<T, int> > temp;
    copy(Map.begin(), Map.end(), back_inserter(temp));
    // My first lambda expression; pretty interesting syntax
    // How does this affect big O?
    sort(temp.begin(), temp.end(), [](auto &left, auto &right) {
    return left.second > right.second;});
    cout << "TOP THREE ENTRIES:" << endl;
    for (int count = 0; count < 3; count ++) {
        cout << "KEY:" << temp[count].first << " VALUE:" << temp[count].second << endl;
    }
}