
#include "../Headers/Item.h"
#include "../Headers/IOHelper.h"

#include <utility>

Item::Item() = default;

Item::Item(std::string name, std::string sellerUsername, std::string highestBidderUsername, int daysLeft, int minimumBid) : name(std::move(name)), sellerUsername(std::move(sellerUsername)), highestBidderUsername(std::move(highestBidderUsername)), daysLeft(daysLeft), currentBid(minimumBid){}

void Item::readFromFile(std::ifstream &fin) {
    //read a line from the file
    std::string line;
    getline(fin, line);

    //parse all the fields
    name = IOHelper::trim(line.substr(0, 19));
    sellerUsername = IOHelper::trim(line.substr(20, 15));
    highestBidderUsername = IOHelper::trim(line.substr(36, 15));
    try {
        daysLeft = stoi(IOHelper::trim(line.substr(52, 3)));
        currentBid = stoi(IOHelper::trim(line.substr(56, 6)));
    }
    catch (std::exception &e){}
}

void Item::writeToFile(std::ofstream &fout){
    //write all the fields to the file
    fout << IOHelper::leftJustify(name, ' ', 19) << ' ';
    fout << IOHelper::leftJustify(sellerUsername, ' ', 15) << ' ';
    fout << IOHelper::leftJustify(highestBidderUsername, ' ', 15) << ' ';
    fout << IOHelper::rightJustify(std::to_string(daysLeft), '0', 3) << ' ';
    fout << IOHelper::rightJustify(std::to_string((int)currentBid), '0', 6);
}
