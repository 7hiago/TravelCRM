package org.laba2.dao;

import org.laba2.entities.Accounting;

public interface AccountingDAO {
    void createAccounting(Accounting accounting);
    Accounting getAccounting(int accounting_id);
    void updateAccounting(int accounting_id, Accounting accounting);
    void removeAccounting(int accounting_id);
}
