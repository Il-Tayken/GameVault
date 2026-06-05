package com.gamevault.discover.data.repository;

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
public final class DiscoverRepositoryImpl_Factory implements Factory<DiscoverRepositoryImpl> {
  private final Provider<RawgApiService> apiProvider;

  public DiscoverRepositoryImpl_Factory(Provider<RawgApiService> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public DiscoverRepositoryImpl get() {
    return newInstance(apiProvider.get());
  }

  public static DiscoverRepositoryImpl_Factory create(Provider<RawgApiService> apiProvider) {
    return new DiscoverRepositoryImpl_Factory(apiProvider);
  }

  public static DiscoverRepositoryImpl newInstance(RawgApiService api) {
    return new DiscoverRepositoryImpl(api);
  }
}
