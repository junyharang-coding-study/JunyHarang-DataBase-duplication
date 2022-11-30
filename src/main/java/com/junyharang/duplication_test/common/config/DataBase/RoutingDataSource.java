package com.junyharang.duplication_test.common.config.DataBase;

import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.jdbc.datasource.lookup.*;

public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {  // 현재 조회 Key를 반환받기 위해 구현해야 하는 추상 Method
        return (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) ? "slave" : "master";
    }
}
