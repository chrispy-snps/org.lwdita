package com.elovirta.dita.markdown;

import com.elovirta.dita.markdown.renderer.NodeRendererContext;
import com.vladsch.flexmark.util.ast.Node;

public abstract class NodeRendererSubContext implements NodeRendererContext {
    final DitaWriter ditaWriter;
    Node renderingNode;
    NodeRenderingHandlerWrapper renderingHandlerWrapper;
    int doNotRenderLinksNesting;

    public NodeRendererSubContext(DitaWriter ditaWriter) {
        this.ditaWriter = ditaWriter;
        this.renderingNode = null;
        this.doNotRenderLinksNesting = 0;
    }

    protected int getDoNotRenderLinksNesting() {
        return doNotRenderLinksNesting;
    }
}
