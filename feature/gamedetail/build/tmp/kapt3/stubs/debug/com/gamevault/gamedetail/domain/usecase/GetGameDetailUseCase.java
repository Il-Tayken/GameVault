package com.gamevault.gamedetail.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/gamevault/gamedetail/domain/usecase/GetGameDetailUseCase;", "", "repository", "Lcom/gamevault/gamedetail/domain/repository/GameDetailRepository;", "(Lcom/gamevault/gamedetail/domain/repository/GameDetailRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/gamevault/gamedetail/domain/model/GameDetail;", "gameId", "", "gamedetail_debug"})
public final class GetGameDetailUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.gamevault.gamedetail.domain.repository.GameDetailRepository repository = null;
    
    @javax.inject.Inject()
    public GetGameDetailUseCase(@org.jetbrains.annotations.NotNull()
    com.gamevault.gamedetail.domain.repository.GameDetailRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.gamevault.gamedetail.domain.model.GameDetail> invoke(int gameId) {
        return null;
    }
}