package com.gamevault.database.di;

import android.content.Context;
import com.gamevault.database.GameVaultDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DatabaseModule_ProvideGameVaultDatabaseFactory implements Factory<GameVaultDatabase> {
  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideGameVaultDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public GameVaultDatabase get() {
    return provideGameVaultDatabase(contextProvider.get());
  }

  public static DatabaseModule_ProvideGameVaultDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideGameVaultDatabaseFactory(contextProvider);
  }

  public static GameVaultDatabase provideGameVaultDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideGameVaultDatabase(context));
  }
}
