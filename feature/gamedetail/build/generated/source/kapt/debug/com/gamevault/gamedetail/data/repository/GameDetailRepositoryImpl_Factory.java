package com.gamevault.gamedetail.data.repository;

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
public final class GameDetailRepositoryImpl_Factory implements Factory<GameDetailRepositoryImpl> {
  private final Provider<RawgApiService> apiServiceProvider;

  private final Provider<GameVaultDatabase> databaseProvider;

  public GameDetailRepositoryImpl_Factory(Provider<RawgApiService> apiServiceProvider,
      Provider<GameVaultDatabase> databaseProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public GameDetailRepositoryImpl get() {
    return newInstance(apiServiceProvider.get(), databaseProvider.get());
  }

  public static GameDetailRepositoryImpl_Factory create(Provider<RawgApiService> apiServiceProvider,
      Provider<GameVaultDatabase> databaseProvider) {
    return new GameDetailRepositoryImpl_Factory(apiServiceProvider, databaseProvider);
  }

  public static GameDetailRepositoryImpl newInstance(RawgApiService apiService,
      GameVaultDatabase database) {
    return new GameDetailRepositoryImpl(apiService, database);
  }
}
