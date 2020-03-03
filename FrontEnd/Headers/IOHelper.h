#ifndef PHASE3_IOHELPER_H
#define PHASE3_IOHELPER_H

#include <string>
#include <sstream>
#include <iostream>

//includes basic tools to help with file formatting
class IOHelper {

public:
    //adds spaces to the left of a string to make it a certain length
    static std::string leftJustify(const std::string& str, char filler, int length){
        std::stringstream sout;
        sout << str;
        for(int i = 0; i < length - (int)str.size(); i++){
            sout << filler;
        }
        return sout.rdbuf()->str();
    }

    //adds spaces to the right of a string to make it a certain length
    static std::string rightJustify(const std::string& str, char filler, int length){
        std::stringstream sout;
        for(int i = 0; i < length - (int)str.size(); i++){
            sout << filler;
        }
        sout << str;
        return sout.rdbuf()->str();
    }

    //removes the extra whitespace from a string
    static std::string trim(const std::string &str) {
        int length = str.length();
        while(length > 0 && str[length-1] == ' '){ length--; }
        return str.substr(0, length);
    }
};

#endif //PHASE3_IOHELPER_H
