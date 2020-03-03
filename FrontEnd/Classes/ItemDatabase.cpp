
#include <iostream>
#include <utility>
#include "../Headers/ItemDatabase.h"
#include "../Headers/IOHelper.h"

ItemDatabase::ItemDatabase(std::string dataFile) : dataFile(std::move(dataFile)){}

Item *ItemDatabase::findItem(const std::string& sellerUsername, const std::string& itemName) {
    //find an item with a matching name and seller
    for(auto & item : items){
        if(item.sellerUsername == sellerUsername && item.name == itemName){
            return &item;
        }
    }
    //return null if no matching item is found
    return nullptr;
}

void ItemDatabase::readFromFile(std::ifstream &fin){
    //read all items until an "End" is found
    items.clear();
    while(true){
        Item item;
        item.readFromFile(fin);

        if(item.name == "END"){ break; }
        items.push_back(item);
    }
}

void ItemDatabase::writeToFile(std::ofstream &fout) {
    //write all items to the file
    for(auto & item : items){
        item.writeToFile(fout);
        fout << std::endl;
    }
    //print an empty line containing just "end"
    fout << IOHelper::leftJustify("END", ' ', 62) << std::endl;
}

//call readFromFile with the command line passed file name
void ItemDatabase::load() {
    std::ifstream fin(dataFile);
    readFromFile(fin);
    fin.close();
}

//call writeToFile with the command line passed file name
void ItemDatabase::save() {
    std::ofstream fout(dataFile);
    writeToFile(fout);
    fout.close();
}
