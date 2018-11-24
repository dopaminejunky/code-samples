/*
** Roger Robertson
** String Compression
** File description:
** CompressedString
*/

#include <algorithm>
#include <string>
#include <iostream>
#include <vector>
#include "CompressedString.h"

CompressedString::CompressedString(string& theString) {
    string uString = theString;
    vector<char> cString = compress(uString);
    cout << cString << endl;
    double compression = ((double)cString.size()/(double)uString.length());
    if (compression < 1) {
    cout << "Compressed string is " << compression * 100 << "% smaller than original." << endl;
    } else {
        cout << "Compressed string is the same length as original." << endl;
    }
}

CompressedString::~CompressedString() {
    cout << endl << "Destroyed." << endl;
}

// O(n^2); nested while loops could have to traverse the entire vector twice
vector<char> CompressedString::compress(string& theString) {
    vector<char> temp = vector<char>(theString.begin(), theString.end());
    vector<char> result = {};
    vector<char>::const_iterator current = temp.begin();
    vector<char>::const_iterator end = temp.end();
    // step through whole vector with iterators
    while (current != end) {
        // count occurrances
        unsigned count = std::count(current, end, *current);
        // if greater than one, append count and char to vector
        if (count != 1) { 
            result.push_back(count);
            result.push_back(*current);
            //else just add char
        } else {
            result.push_back(*current);
        }
        // increase index while current char is equal to saved char
        char saved = *current;
        while (*current == saved) {
            ++current;
        }
    }
    return result;

}

void CompressedString::print() {
    cout << &cString;
}

//O(n^2) nested for loops
ostream& operator<<(ostream& outStream, const vector<char>& cString) {
    string output;
    for (int index = 0; index < cString.size(); index++) {
        if (cString[index] >= 0 && cString[index] <= 10) {
            int count = cString[index];
            for (int cCount = 0; cCount < count; cCount++) {
                output += cString[index + 1];
            }
        } else {
            output += cString[index];
        }
    }
    outStream << output;

    return outStream;
}