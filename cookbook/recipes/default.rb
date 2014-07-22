#
# Cookbook Name:: cb-nginx
# Recipe:: default
#

# Configure common
include_recipe 'cb-common'

# Configure tomcat
include_recipe 'cb-tomcat'
directory 'opt/tomcat/conf/webapps' do
  recursive true
  mode '755'
  action :create
end
template '/opt/tomcat/conf/webapps/api.properties' do
  source 'api.properties.erb'
  mode '644'
  notifies :restart, 'service[tomcat]', :delayed
end
directory '/opt/tomcat/conf/Catalina/localhost' do
  recursive true
  mode '755'
  action :create
end
template '/opt/tomcat/conf/Catalina/localhost/api.xml' do
  source 'api.xml.erb'
  mode '644'
  notifies :restart, 'service[tomcat]', :delayed
end

# Configure nginx
include_recipe 'cb-nginx'
file '/etc/nginx/sites-available/default' do
  action :delete
end
file '/etc/nginx/conf.d/default.conf' do
  action :delete
end
file '/etc/nginx/conf.d/example_ssl.conf' do
  action :delete
end
template '/etc/nginx/sites-enabled/app.conf' do
  source 'app.conf.erb'
  mode '644'
  notifies :restart, 'service[nginx]', :delayed
end