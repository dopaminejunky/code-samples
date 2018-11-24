/*
** Roger Robertson
** String Compression
** File description:
** CompressedString
*/



#ifndef CompressedString_H
#define CompressedString_H
using namespace std;
#include <string>
#include <vector>
#include <iterator>
#include <iostream>

ostream& operator<<(ostream& outStream, const vector<char>& cString);


class CompressedString {

    public:
    CompressedString(string& theString);
    ~CompressedString();
    void print();

    private:
    string uString;
    vector<char> cString;
    vector<char> compress(string& theString);



};
#endif // !CompressedString_H
