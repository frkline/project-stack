#
# Cookbook Name:: cb-nginx
# Recipe:: default
#

# Configure common
include_recipe 'cb-common'

# Configure tomcat
include_recipe 'cb-tomcat'

# Configure nginx
include_recipe 'cb-nginx'
file '/etc/conf.d/' do
  action :delete
end
file '/etc/nginx/conf.d/default.conf' do
  action :delete
end
template '/etc/nginx/sites-enabled/app.conf' do
  source 'app.conf.erb'
  mode '644'
  notifies :restart, 'service[nginx]', :delayed
end