package org.laba2.dao;

import org.laba2.entities.Accounting;

public interface AccountingDAO {
    void createAccounting(Accounting accounting);
    Accounting getAccounting(String accounting_id);
    void updateAccounting(String accounting_id, Accounting accounting);
    void removeAccounting(String accounting_id);
}