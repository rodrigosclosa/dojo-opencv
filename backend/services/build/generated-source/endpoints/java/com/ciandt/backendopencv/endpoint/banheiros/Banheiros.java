/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-10-17 16:43:55 UTC)
 * on 2016-12-15 at 14:47:44 UTC 
 * Modify at your own risk.
 */

package com.ciandt.backendopencv.endpoint.banheiros;

/**
 * Service definition for Banheiros (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link BanheirosRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Banheiros extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.22.0 of the banheiros library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://dojo-opencv-cit.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "banheiros/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Banheiros(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Banheiros(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getBanheiro".
   *
   * This request holds the parameters needed by the banheiros server.  After setting any optional
   * parameters, call the {@link GetBanheiro#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetBanheiro getBanheiro(java.lang.String id) throws java.io.IOException {
    GetBanheiro result = new GetBanheiro(id);
    initialize(result);
    return result;
  }

  public class GetBanheiro extends BanheirosRequest<com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro> {

    private static final String REST_PATH = "get/{id}";

    /**
     * Create a request for the method "getBanheiro".
     *
     * This request holds the parameters needed by the the banheiros server.  After setting any
     * optional parameters, call the {@link GetBanheiro#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetBanheiro#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetBanheiro(java.lang.String id) {
      super(Banheiros.this, "GET", REST_PATH, null, com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetBanheiro setAlt(java.lang.String alt) {
      return (GetBanheiro) super.setAlt(alt);
    }

    @Override
    public GetBanheiro setFields(java.lang.String fields) {
      return (GetBanheiro) super.setFields(fields);
    }

    @Override
    public GetBanheiro setKey(java.lang.String key) {
      return (GetBanheiro) super.setKey(key);
    }

    @Override
    public GetBanheiro setOauthToken(java.lang.String oauthToken) {
      return (GetBanheiro) super.setOauthToken(oauthToken);
    }

    @Override
    public GetBanheiro setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetBanheiro) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetBanheiro setQuotaUser(java.lang.String quotaUser) {
      return (GetBanheiro) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetBanheiro setUserIp(java.lang.String userIp) {
      return (GetBanheiro) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetBanheiro setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public GetBanheiro set(String parameterName, Object value) {
      return (GetBanheiro) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getBanheiros".
   *
   * This request holds the parameters needed by the banheiros server.  After setting any optional
   * parameters, call the {@link GetBanheiros#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public GetBanheiros getBanheiros() throws java.io.IOException {
    GetBanheiros result = new GetBanheiros();
    initialize(result);
    return result;
  }

  public class GetBanheiros extends BanheirosRequest<com.ciandt.backendopencv.endpoint.banheiros.model.BanheiroCollection> {

    private static final String REST_PATH = "get";

    /**
     * Create a request for the method "getBanheiros".
     *
     * This request holds the parameters needed by the the banheiros server.  After setting any
     * optional parameters, call the {@link GetBanheiros#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetBanheiros#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected GetBanheiros() {
      super(Banheiros.this, "GET", REST_PATH, null, com.ciandt.backendopencv.endpoint.banheiros.model.BanheiroCollection.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetBanheiros setAlt(java.lang.String alt) {
      return (GetBanheiros) super.setAlt(alt);
    }

    @Override
    public GetBanheiros setFields(java.lang.String fields) {
      return (GetBanheiros) super.setFields(fields);
    }

    @Override
    public GetBanheiros setKey(java.lang.String key) {
      return (GetBanheiros) super.setKey(key);
    }

    @Override
    public GetBanheiros setOauthToken(java.lang.String oauthToken) {
      return (GetBanheiros) super.setOauthToken(oauthToken);
    }

    @Override
    public GetBanheiros setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetBanheiros) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetBanheiros setQuotaUser(java.lang.String quotaUser) {
      return (GetBanheiros) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetBanheiros setUserIp(java.lang.String userIp) {
      return (GetBanheiros) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String predio;

    /**

     */
    public java.lang.String getPredio() {
      return predio;
    }

    public GetBanheiros setPredio(java.lang.String predio) {
      this.predio = predio;
      return this;
    }

    @Override
    public GetBanheiros set(String parameterName, Object value) {
      return (GetBanheiros) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertBanheiro".
   *
   * This request holds the parameters needed by the banheiros server.  After setting any optional
   * parameters, call the {@link InsertBanheiro#execute()} method to invoke the remote operation.
   *
   * @param content the {@link com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro}
   * @return the request
   */
  public InsertBanheiro insertBanheiro(com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro content) throws java.io.IOException {
    InsertBanheiro result = new InsertBanheiro(content);
    initialize(result);
    return result;
  }

  public class InsertBanheiro extends BanheirosRequest<com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro> {

    private static final String REST_PATH = "new";

    /**
     * Create a request for the method "insertBanheiro".
     *
     * This request holds the parameters needed by the the banheiros server.  After setting any
     * optional parameters, call the {@link InsertBanheiro#execute()} method to invoke the remote
     * operation. <p> {@link InsertBanheiro#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro}
     * @since 1.13
     */
    protected InsertBanheiro(com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro content) {
      super(Banheiros.this, "POST", REST_PATH, content, com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro.class);
    }

    @Override
    public InsertBanheiro setAlt(java.lang.String alt) {
      return (InsertBanheiro) super.setAlt(alt);
    }

    @Override
    public InsertBanheiro setFields(java.lang.String fields) {
      return (InsertBanheiro) super.setFields(fields);
    }

    @Override
    public InsertBanheiro setKey(java.lang.String key) {
      return (InsertBanheiro) super.setKey(key);
    }

    @Override
    public InsertBanheiro setOauthToken(java.lang.String oauthToken) {
      return (InsertBanheiro) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertBanheiro setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertBanheiro) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertBanheiro setQuotaUser(java.lang.String quotaUser) {
      return (InsertBanheiro) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertBanheiro setUserIp(java.lang.String userIp) {
      return (InsertBanheiro) super.setUserIp(userIp);
    }

    @Override
    public InsertBanheiro set(String parameterName, Object value) {
      return (InsertBanheiro) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeBanheiro".
   *
   * This request holds the parameters needed by the banheiros server.  After setting any optional
   * parameters, call the {@link RemoveBanheiro#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public RemoveBanheiro removeBanheiro(java.lang.String id) throws java.io.IOException {
    RemoveBanheiro result = new RemoveBanheiro(id);
    initialize(result);
    return result;
  }

  public class RemoveBanheiro extends BanheirosRequest<Void> {

    private static final String REST_PATH = "delete/{id}";

    /**
     * Create a request for the method "removeBanheiro".
     *
     * This request holds the parameters needed by the the banheiros server.  After setting any
     * optional parameters, call the {@link RemoveBanheiro#execute()} method to invoke the remote
     * operation. <p> {@link RemoveBanheiro#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveBanheiro(java.lang.String id) {
      super(Banheiros.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveBanheiro setAlt(java.lang.String alt) {
      return (RemoveBanheiro) super.setAlt(alt);
    }

    @Override
    public RemoveBanheiro setFields(java.lang.String fields) {
      return (RemoveBanheiro) super.setFields(fields);
    }

    @Override
    public RemoveBanheiro setKey(java.lang.String key) {
      return (RemoveBanheiro) super.setKey(key);
    }

    @Override
    public RemoveBanheiro setOauthToken(java.lang.String oauthToken) {
      return (RemoveBanheiro) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveBanheiro setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveBanheiro) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveBanheiro setQuotaUser(java.lang.String quotaUser) {
      return (RemoveBanheiro) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveBanheiro setUserIp(java.lang.String userIp) {
      return (RemoveBanheiro) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public RemoveBanheiro setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveBanheiro set(String parameterName, Object value) {
      return (RemoveBanheiro) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateBanheiro".
   *
   * This request holds the parameters needed by the banheiros server.  After setting any optional
   * parameters, call the {@link UpdateBanheiro#execute()} method to invoke the remote operation.
   *
   * @param content the {@link com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro}
   * @return the request
   */
  public UpdateBanheiro updateBanheiro(com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro content) throws java.io.IOException {
    UpdateBanheiro result = new UpdateBanheiro(content);
    initialize(result);
    return result;
  }

  public class UpdateBanheiro extends BanheirosRequest<Void> {

    private static final String REST_PATH = "update";

    /**
     * Create a request for the method "updateBanheiro".
     *
     * This request holds the parameters needed by the the banheiros server.  After setting any
     * optional parameters, call the {@link UpdateBanheiro#execute()} method to invoke the remote
     * operation. <p> {@link UpdateBanheiro#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro}
     * @since 1.13
     */
    protected UpdateBanheiro(com.ciandt.backendopencv.endpoint.banheiros.model.Banheiro content) {
      super(Banheiros.this, "PUT", REST_PATH, content, Void.class);
    }

    @Override
    public UpdateBanheiro setAlt(java.lang.String alt) {
      return (UpdateBanheiro) super.setAlt(alt);
    }

    @Override
    public UpdateBanheiro setFields(java.lang.String fields) {
      return (UpdateBanheiro) super.setFields(fields);
    }

    @Override
    public UpdateBanheiro setKey(java.lang.String key) {
      return (UpdateBanheiro) super.setKey(key);
    }

    @Override
    public UpdateBanheiro setOauthToken(java.lang.String oauthToken) {
      return (UpdateBanheiro) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateBanheiro setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateBanheiro) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateBanheiro setQuotaUser(java.lang.String quotaUser) {
      return (UpdateBanheiro) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateBanheiro setUserIp(java.lang.String userIp) {
      return (UpdateBanheiro) super.setUserIp(userIp);
    }

    @Override
    public UpdateBanheiro set(String parameterName, Object value) {
      return (UpdateBanheiro) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Banheiros}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Banheiros}. */
    @Override
    public Banheiros build() {
      return new Banheiros(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link BanheirosRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setBanheirosRequestInitializer(
        BanheirosRequestInitializer banheirosRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(banheirosRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
