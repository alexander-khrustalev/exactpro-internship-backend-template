import io.javalin.Javalin;
import models.IAlert;
import models.IHistogramChartData;
import models.IPieChartData;
import models.ITransaction;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Javalin application = Javalin.create().start(8080);

        application.get("/process-status", ctx -> {
            /* It can be enum element or complex object */
            ctx.result("Send the status of the process here");
        });

        application.get("/alerts-table", ctx -> {
            /*
            * URL can contain query parameters:
            * alert-id - filter value for 'Alert ID' column
            * alert-type - filter value for 'Alert Type' column
            * sorting - type of sorting, column name for example
            */
            List<IAlert> alerts = null /* get alerts from db */ ;
            ctx.json(alerts);
        });

        application.get("/transactions-for-alert-table/:alert-id", ctx -> {
            /*
             * URL must contain path parameter 'alert-id'
             * URL can contain query parameters:
             * execution-entity-name - filter value for 'Execution Entity Name' column
             * instrument-name - filter value for 'Instrument Name' column
             * instrument-classification - filter value for 'Instrument Classification' column
             * sorting - type of sorting, column name for example
             */
            List<ITransaction> transactions = null /* get transactions from db for alert with alert-id */ ;
            ctx.json(transactions);
        });

        application.get("/pie-chart-data", ctx -> {
            IPieChartData data = null /* get chart data from db */ ;
            ctx.json(data);
        });

        application.get("/histogram-chart-data", ctx -> {
            IHistogramChartData data = null /* get chart data from db */ ;
            ctx.json(data);
        });
    }
}
