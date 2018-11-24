/*
 * Created on Wed Oct 31 2018
 *
 * Copyright (c) 2018 Roger Robertson Jr
 */
#include "Element.h"
#include <iostream>


//TODO: Enforce invariants.
template<class T>
Element<T>::Element(T data) {
    this->data = data;

}

template<class T>
Element<T>::~Element() {
    cout << "Destroyed." << endl;
}

template<class T>
bool Element<T>::operator==(const Element &element) const {
    if (element.data == this->data) {
        return true;
    }
    return false;
}
template<class T>
void Element<T>::print() {
    cout << this->data << endl;
}
 