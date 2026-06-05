package com.gamevault.gamelist.data.repository;

import com.gamevault.database.GameVaultDatabase;
import com.gamevault.network.api.RawgApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class GameListRepositoryImpl_Factory implements Factory<GameListRepositoryImpl> {
  private final Provider<RawgApiService> apiServiceProvider;

  private final Provider<GameVaultDatabase> databaseProvider;

  public GameListRepositoryImpl_Factory(Provider<RawgApiService> apiServiceProvider,
      Provider<GameVaultDatabase> databaseProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public GameListRepositoryImpl get() {
    return newInstance(apiServiceProvider.get(), databaseProvider.get());
  }

  public static GameListRepositoryImpl_Factory create(Provider<RawgApiService> apiServiceProvider,
      Provider<GameVaultDatabase> databaseProvider) {
    return new GameListRepositoryImpl_Factory(apiServiceProvider, databaseProvider);
  }

  public static GameListRepositoryImpl newInstance(RawgApiService apiService,
      GameVaultDatabase database) {
    return new GameListRepositoryImpl(apiService, database);
  }
}
