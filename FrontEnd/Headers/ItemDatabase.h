#ifndef PHASE3_ITEMDATABASE_H
#define PHASE3_ITEMDATABASE_H

#include <vector>
#include <istream>
#include <fstream>
#include "Item.h"

//stores a database of all available items
class ItemDatabase {
public:
    std::string dataFile;
    std::vector<Item> items;

    ItemDatabase(std::string dataFile);

    //find an item using the seller and item name. Returns null if item is not found
    Item* findItem(const std::string& sellerUsername, const std::string& itemName);

    void readFromFile(std::ifstream &fin);
    void writeToFile(std::ofstream &fout);

    //ease of use functions, call read/write automatically with the dataFile
    void load();
    void save();
};

#endif //PHASE3_ITEMDATABASE_H
