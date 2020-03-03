
#ifndef PHASE3_SALESSERVICE_H
#define PHASE3_SALESSERVICE_H

#include "../ItemDatabase.h"
#include "../SessionHandler.h"

//This class is an endpoint. User for interacting with items / tickets
class SalesService {
private:
    SessionHandler &sessionHandler;
    ItemDatabase &itemDatabase;

public:
    SalesService(SessionHandler &sessionHandler, ItemDatabase &itemDatabase);

    void advertise();
    void bid();
};

#endif //PHASE3_SALESSERVICE_H
