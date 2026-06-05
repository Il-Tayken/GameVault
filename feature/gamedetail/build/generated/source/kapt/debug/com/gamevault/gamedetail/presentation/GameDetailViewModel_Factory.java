package com.gamevault.gamedetail.presentation;

import androidx.lifecycle.SavedStateHandle;
import com.gamevault.gamedetail.domain.usecase.FetchGameDetailUseCase;
import com.gamevault.gamedetail.domain.usecase.GetGameDetailUseCase;
import com.gamevault.gamedetail.domain.usecase.ToggleDetailFavoriteUseCase;
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
public final class GameDetailViewModel_Factory implements Factory<GameDetailViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<GetGameDetailUseCase> getGameDetailUseCaseProvider;

  private final Provider<FetchGameDetailUseCase> fetchGameDetailUseCaseProvider;

  private final Provider<ToggleDetailFavoriteUseCase> toggleFavoriteUseCaseProvider;

  public GameDetailViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<GetGameDetailUseCase> getGameDetailUseCaseProvider,
      Provider<FetchGameDetailUseCase> fetchGameDetailUseCaseProvider,
      Provider<ToggleDetailFavoriteUseCase> toggleFavoriteUseCaseProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.getGameDetailUseCaseProvider = getGameDetailUseCaseProvider;
    this.fetchGameDetailUseCaseProvider = fetchGameDetailUseCaseProvider;
    this.toggleFavoriteUseCaseProvider = toggleFavoriteUseCaseProvider;
  }

  @Override
  public GameDetailViewModel get() {
    return newInstance(savedStateHandleProvider.get(), getGameDetailUseCaseProvider.get(), fetchGameDetailUseCaseProvider.get(), toggleFavoriteUseCaseProvider.get());
  }

  public static GameDetailViewModel_Factory create(
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<GetGameDetailUseCase> getGameDetailUseCaseProvider,
      Provider<FetchGameDetailUseCase> fetchGameDetailUseCaseProvider,
      Provider<ToggleDetailFavoriteUseCase> toggleFavoriteUseCaseProvider) {
    return new GameDetailViewModel_Factory(savedStateHandleProvider, getGameDetailUseCaseProvider, fetchGameDetailUseCaseProvider, toggleFavoriteUseCaseProvider);
  }

  public static GameDetailViewModel newInstance(SavedStateHandle savedStateHandle,
      GetGameDetailUseCase getGameDetailUseCase, FetchGameDetailUseCase fetchGameDetailUseCase,
      ToggleDetailFavoriteUseCase toggleFavoriteUseCase) {
    return new GameDetailViewModel(savedStateHandle, getGameDetailUseCase, fetchGameDetailUseCase, toggleFavoriteUseCase);
  }
}
