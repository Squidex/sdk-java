package com.squidex.api;

import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.Suppliers;
import com.squidex.api.resources.apps.AppsClient;
import com.squidex.api.resources.assets.AssetsClient;
import com.squidex.api.resources.backups.BackupsClient;
import com.squidex.api.resources.comments.CommentsClient;
import com.squidex.api.resources.contents.ContentsClient;
import com.squidex.api.resources.diagnostics.DiagnosticsClient;
import com.squidex.api.resources.eventconsumers.EventConsumersClient;
import com.squidex.api.resources.history.HistoryClient;
import com.squidex.api.resources.languages.LanguagesClient;
import com.squidex.api.resources.news.NewsClient;
import com.squidex.api.resources.notifications.NotificationsClient;
import com.squidex.api.resources.ping.PingClient;
import com.squidex.api.resources.plans.PlansClient;
import com.squidex.api.resources.rules.RulesClient;
import com.squidex.api.resources.schemas.SchemasClient;
import com.squidex.api.resources.search.SearchClient;
import com.squidex.api.resources.statistics.StatisticsClient;
import com.squidex.api.resources.teams.TeamsClient;
import com.squidex.api.resources.templates.TemplatesClient;
import com.squidex.api.resources.translations.TranslationsClient;
import com.squidex.api.resources.usermanagement.UserManagementClient;
import com.squidex.api.resources.users.UsersClient;
import java.util.function.Supplier;

public class SquidexApiClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<UserManagementClient> userManagementClient;

    protected final Supplier<UsersClient> usersClient;

    protected final Supplier<TranslationsClient> translationsClient;

    protected final Supplier<TemplatesClient> templatesClient;

    protected final Supplier<TeamsClient> teamsClient;

    protected final Supplier<StatisticsClient> statisticsClient;

    protected final Supplier<SearchClient> searchClient;

    protected final Supplier<SchemasClient> schemasClient;

    protected final Supplier<RulesClient> rulesClient;

    protected final Supplier<PlansClient> plansClient;

    protected final Supplier<PingClient> pingClient;

    protected final Supplier<NewsClient> newsClient;

    protected final Supplier<LanguagesClient> languagesClient;

    protected final Supplier<HistoryClient> historyClient;

    protected final Supplier<EventConsumersClient> eventConsumersClient;

    protected final Supplier<DiagnosticsClient> diagnosticsClient;

    protected final Supplier<ContentsClient> contentsClient;

    protected final Supplier<CommentsClient> commentsClient;

    protected final Supplier<NotificationsClient> notificationsClient;

    protected final Supplier<BackupsClient> backupsClient;

    protected final Supplier<AssetsClient> assetsClient;

    protected final Supplier<AppsClient> appsClient;

    public SquidexApiClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.userManagementClient = Suppliers.memoize(() -> new UserManagementClient(clientOptions));
        this.usersClient = Suppliers.memoize(() -> new UsersClient(clientOptions));
        this.translationsClient = Suppliers.memoize(() -> new TranslationsClient(clientOptions));
        this.templatesClient = Suppliers.memoize(() -> new TemplatesClient(clientOptions));
        this.teamsClient = Suppliers.memoize(() -> new TeamsClient(clientOptions));
        this.statisticsClient = Suppliers.memoize(() -> new StatisticsClient(clientOptions));
        this.searchClient = Suppliers.memoize(() -> new SearchClient(clientOptions));
        this.schemasClient = Suppliers.memoize(() -> new SchemasClient(clientOptions));
        this.rulesClient = Suppliers.memoize(() -> new RulesClient(clientOptions));
        this.plansClient = Suppliers.memoize(() -> new PlansClient(clientOptions));
        this.pingClient = Suppliers.memoize(() -> new PingClient(clientOptions));
        this.newsClient = Suppliers.memoize(() -> new NewsClient(clientOptions));
        this.languagesClient = Suppliers.memoize(() -> new LanguagesClient(clientOptions));
        this.historyClient = Suppliers.memoize(() -> new HistoryClient(clientOptions));
        this.eventConsumersClient = Suppliers.memoize(() -> new EventConsumersClient(clientOptions));
        this.diagnosticsClient = Suppliers.memoize(() -> new DiagnosticsClient(clientOptions));
        this.contentsClient = Suppliers.memoize(() -> new ContentsClient(clientOptions));
        this.commentsClient = Suppliers.memoize(() -> new CommentsClient(clientOptions));
        this.notificationsClient = Suppliers.memoize(() -> new NotificationsClient(clientOptions));
        this.backupsClient = Suppliers.memoize(() -> new BackupsClient(clientOptions));
        this.assetsClient = Suppliers.memoize(() -> new AssetsClient(clientOptions));
        this.appsClient = Suppliers.memoize(() -> new AppsClient(clientOptions));
    }

    public UserManagementClient userManagement() {
        return this.userManagementClient.get();
    }

    public UsersClient users() {
        return this.usersClient.get();
    }

    public TranslationsClient translations() {
        return this.translationsClient.get();
    }

    public TemplatesClient templates() {
        return this.templatesClient.get();
    }

    public TeamsClient teams() {
        return this.teamsClient.get();
    }

    public StatisticsClient statistics() {
        return this.statisticsClient.get();
    }

    public SearchClient search() {
        return this.searchClient.get();
    }

    public SchemasClient schemas() {
        return this.schemasClient.get();
    }

    public RulesClient rules() {
        return this.rulesClient.get();
    }

    public PlansClient plans() {
        return this.plansClient.get();
    }

    public PingClient ping() {
        return this.pingClient.get();
    }

    public NewsClient news() {
        return this.newsClient.get();
    }

    public LanguagesClient languages() {
        return this.languagesClient.get();
    }

    public HistoryClient history() {
        return this.historyClient.get();
    }

    public EventConsumersClient eventConsumers() {
        return this.eventConsumersClient.get();
    }

    public DiagnosticsClient diagnostics() {
        return this.diagnosticsClient.get();
    }

    public ContentsClient contents() {
        return this.contentsClient.get();
    }

    public CommentsClient comments() {
        return this.commentsClient.get();
    }

    public NotificationsClient notifications() {
        return this.notificationsClient.get();
    }

    public BackupsClient backups() {
        return this.backupsClient.get();
    }

    public AssetsClient assets() {
        return this.assetsClient.get();
    }

    public AppsClient apps() {
        return this.appsClient.get();
    }

    public static SquidexApiClientBuilder builder() {
        return new SquidexApiClientBuilder();
    }
}
