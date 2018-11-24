/*
 * Created on Wed Oct 31 2018
 *
 * Copyright (c) 2018 Roger Robertson Jr
 */
#ifndef ELEMENT_H_
#define ELEMENT_H_
//using namespace std;

template<class T>
class Element {

    public:
    Element(T data);
    ~Element();
    bool operator==(const Element &element) const;
    void print();

    private:
    T data;


};


#endif // !ELEMENT_H_
