package controllers;

import api.CreateReceiptRequest;
import api.CreateTagRequest;
import api.ReceiptResponse;
import api.TagResponse;
import dao.ReceiptDao;
import dao.TagDao;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagsRecord;


import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import static java.util.stream.Collectors.toList;

@Path("/tags")
@Consumes(MediaType.APPLICATION_JSON)
public class ReceiptTagController {
    final TagDao tags;
    final ReceiptDao receipts;

    public ReceiptTagController(TagDao tags, ReceiptDao receipts) {
        this.tags = tags;
        this.receipts = receipts;
    }

    @PUT
    @Path("/{tag}")
    public int toggleTag(@PathParam("tag") String tagName, @Valid @NotNull CreateTagRequest receipt) {
        return tags.insert(tagName, receipt.id);
    }

    @GET
    @Path("/{tag}")
    public List<ReceiptsRecord> getTaggedReceipts(@PathParam("tag") String tagName){
        List<ReceiptsRecord> receiptRecords = receipts.getAllReceipts();
        ArrayList<ReceiptsRecord> receiptsRecordResponse = new ArrayList<ReceiptsRecord>();

        for (TagsRecord tr: tags.getAllTags()) {
            if (tr.getTag().equals(tagName)){
                for(ReceiptsRecord rr: receiptRecords) {
                    if(rr.getId().equals(tr.getRecieptid())) {
                        receiptsRecordResponse.add(rr);
                    }
                }
                break;
            }
        }

        return receiptsRecordResponse.stream().collect(toList());
    }


}
