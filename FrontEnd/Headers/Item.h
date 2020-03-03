#ifndef PHASE3_ITEM_H
#define PHASE3_ITEM_H

#include <string>
#include <fstream>

//stores a single item
class Item {
public:
    std::string name;
    std::string sellerUsername;
    std::string highestBidderUsername; //can be an empty string if there are no bidders
    int daysLeft{};
    double currentBid{};

    Item();
    Item(std::string name, std::string sellerUsername, std::string highestBidderUsername, int daysLeft, int minimumBid);

    void readFromFile(std::ifstream &fin);
    void writeToFile(std::ofstream &fout);
};

#endif //PHASE3_ITEM_H
