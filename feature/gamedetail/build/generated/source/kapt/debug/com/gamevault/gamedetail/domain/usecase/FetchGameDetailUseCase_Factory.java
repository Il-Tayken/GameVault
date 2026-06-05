package com.gamevault.gamedetail.domain.usecase;

import com.gamevault.gamedetail.domain.repository.GameDetailRepository;
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
public final class FetchGameDetailUseCase_Factory implements Factory<FetchGameDetailUseCase> {
  private final Provider<GameDetailRepository> repositoryProvider;

  public FetchGameDetailUseCase_Factory(Provider<GameDetailRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public FetchGameDetailUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static FetchGameDetailUseCase_Factory create(
      Provider<GameDetailRepository> repositoryProvider) {
    return new FetchGameDetailUseCase_Factory(repositoryProvider);
  }

  public static FetchGameDetailUseCase newInstance(GameDetailRepository repository) {
    return new FetchGameDetailUseCase(repository);
  }
}
