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
public final class GetGameDetailUseCase_Factory implements Factory<GetGameDetailUseCase> {
  private final Provider<GameDetailRepository> repositoryProvider;

  public GetGameDetailUseCase_Factory(Provider<GameDetailRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetGameDetailUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetGameDetailUseCase_Factory create(
      Provider<GameDetailRepository> repositoryProvider) {
    return new GetGameDetailUseCase_Factory(repositoryProvider);
  }

  public static GetGameDetailUseCase newInstance(GameDetailRepository repository) {
    return new GetGameDetailUseCase(repository);
  }
}
