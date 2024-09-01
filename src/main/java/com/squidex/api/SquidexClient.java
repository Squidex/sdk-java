package com.squidex.api;

import com.squidex.api.core.ApiClient;
import com.squidex.api.core.api.AppsApi;
import com.squidex.api.core.api.AssetsApi;
import com.squidex.api.core.api.BackupsApi;
import com.squidex.api.core.api.ContentsApi;
import com.squidex.api.core.api.DiagnosticsApi;
import com.squidex.api.core.api.EventConsumersApi;
import com.squidex.api.core.api.HistoryApi;
import com.squidex.api.core.api.LanguagesApi;
import com.squidex.api.core.api.NewsApi;
import com.squidex.api.core.api.PingApi;
import com.squidex.api.core.api.PlansApi;
import com.squidex.api.core.api.RulesApi;
import com.squidex.api.core.api.SchemasApi;
import com.squidex.api.core.api.SearchApi;
import com.squidex.api.core.api.StatisticsApi;
import com.squidex.api.core.api.TeamsApi;
import com.squidex.api.core.api.TemplatesApi;
import com.squidex.api.core.api.TranslationsApi;
import com.squidex.api.core.api.UserManagementApi;
import com.squidex.api.core.api.UsersApi;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class SquidexClient {
    private final Supplier<AppsApi> appsApi;
    private final Supplier<AssetsApi> assetsApi;
    private final Supplier<BackupsApi> backupsApi;
    private final Supplier<ContentsApi> contentsApi;
    private final Supplier<DiagnosticsApi> diagnosticsApi;
    private final Supplier<EventConsumersApi> eventConsumersApi;
    private final Supplier<HistoryApi> historyApi;
    private final Supplier<LanguagesApi> languagesApi;
    private final Supplier<NewsApi> newsApi;
    private final Supplier<PingApi> pingApi;
    private final Supplier<PlansApi> plansApi;
    private final Supplier<RulesApi> rulesApi;
    private final Supplier<SchemasApi> schemasApi;
    private final Supplier<SearchApi> searchApi;
    private final Supplier<StatisticsApi> statisticsApi;
    private final Supplier<TeamsApi> teamsApi;
    private final Supplier<TemplatesApi> templatesApi;
    private final Supplier<TranslationsApi> translationsApi;
    private final Supplier<UserManagementApi> userManagementApi;
    private final Supplier<UsersApi> usersApi;
    private final String appName;
    private final String clientId;
    private final String clientSecret;
    private final String baseUrl;

    public SquidexClient(ApiClient apiClient, String appName, String clientId, String clientSecret, String baseUrl) {
        this.appName = appName;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.baseUrl = baseUrl;
        this.appsApi = memoize(() -> new AppsApi(apiClient));
        this.assetsApi = memoize(() -> new AssetsApi(apiClient));
        this.backupsApi = memoize(() -> new BackupsApi(apiClient));
        this.contentsApi = memoize(() -> new ContentsApi(apiClient));
        this.diagnosticsApi = memoize(() -> new DiagnosticsApi(apiClient));
        this.eventConsumersApi = memoize(() -> new EventConsumersApi(apiClient));
        this.historyApi = memoize(() -> new HistoryApi(apiClient));
        this.languagesApi = memoize(() -> new LanguagesApi(apiClient));
        this.newsApi = memoize(() -> new NewsApi(apiClient));
        this.pingApi = memoize(() -> new PingApi(apiClient));
        this.plansApi = memoize(() -> new PlansApi(apiClient));
        this.rulesApi = memoize(() -> new RulesApi(apiClient));
        this.schemasApi = memoize(() -> new SchemasApi(apiClient));
        this.searchApi = memoize(() -> new SearchApi(apiClient));
        this.statisticsApi = memoize(() -> new StatisticsApi(apiClient));
        this.teamsApi = memoize(() -> new TeamsApi(apiClient));
        this.templatesApi = memoize(() -> new TemplatesApi(apiClient));
        this.translationsApi = memoize(() -> new TranslationsApi(apiClient));
        this.userManagementApi = memoize(() -> new UserManagementApi(apiClient));
        this.usersApi = memoize(() -> new UsersApi(apiClient));
    }

    static <T> Supplier<T> memoize(Supplier<T> delegate) {
        AtomicReference<T> value = new AtomicReference<>();
        return () -> {
            T val = value.get();
            if (val == null) {
                val = value.updateAndGet(cur -> cur == null ? Objects.requireNonNull(delegate.get()) : cur);
            }
            return val;
        };
    }

    public static SquidexClientBuilder builder() {
        return new SquidexClientBuilder();
    }

    public String getAppName() {
        return appName;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public UserManagementApi userManagement() {
        return this.userManagementApi.get();
    }

    public UsersApi users() {
        return this.usersApi.get();
    }

    public TranslationsApi translations() {
        return this.translationsApi.get();
    }

    public TemplatesApi templates() {
        return this.templatesApi.get();
    }

    public TeamsApi teams() {
        return this.teamsApi.get();
    }

    public StatisticsApi statistics() {
        return this.statisticsApi.get();
    }

    public SearchApi search() {
        return this.searchApi.get();
    }

    public SchemasApi schemas() {
        return this.schemasApi.get();
    }

    public RulesApi rules() {
        return this.rulesApi.get();
    }

    public PlansApi plans() {
        return this.plansApi.get();
    }

    public PingApi ping() {
        return this.pingApi.get();
    }

    public NewsApi news() {
        return this.newsApi.get();
    }

    public LanguagesApi languages() {
        return this.languagesApi.get();
    }

    public HistoryApi history() {
        return this.historyApi.get();
    }

    public EventConsumersApi eventConsumers() {
        return this.eventConsumersApi.get();
    }

    public DiagnosticsApi diagnostics() {
        return this.diagnosticsApi.get();
    }

    public ContentsApi contents() {
        return this.contentsApi.get();
    }

    public BackupsApi backups() {
        return this.backupsApi.get();
    }

    public AssetsApi assets() {
        return this.assetsApi.get();
    }

    public AppsApi apps() {
        return this.appsApi.get();
    }
}
