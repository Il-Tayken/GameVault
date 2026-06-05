package com.gamevault.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/gamevault/database/GameVaultDatabase;", "Lapp/cash/sqldelight/Transacter;", "gameEntityQueries", "Lcom/gamevault/database/GameEntityQueries;", "getGameEntityQueries", "()Lcom/gamevault/database/GameEntityQueries;", "Companion", "database_debug"})
public abstract interface GameVaultDatabase extends app.cash.sqldelight.Transacter {
    @org.jetbrains.annotations.NotNull()
    public static final com.gamevault.database.GameVaultDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gamevault.database.GameEntityQueries getGameEntityQueries();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/gamevault/database/GameVaultDatabase$Companion;", "", "()V", "Schema", "Lapp/cash/sqldelight/db/SqlSchema;", "Lapp/cash/sqldelight/db/QueryResult$Value;", "", "getSchema", "()Lapp/cash/sqldelight/db/SqlSchema;", "invoke", "Lcom/gamevault/database/GameVaultDatabase;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "database_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final app.cash.sqldelight.db.SqlSchema<app.cash.sqldelight.db.QueryResult.Value<kotlin.Unit>> getSchema() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gamevault.database.GameVaultDatabase invoke(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.db.SqlDriver driver) {
            return null;
        }
    }
}